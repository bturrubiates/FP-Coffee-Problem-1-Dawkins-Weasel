(ns weasel.core
  (:require [clojure.tools.cli :refer [parse-opts]]
            [clojure.string :as string])
  (:gen-class))

(def alphabet "ABCDEFGHIJKLMNOPQRSTUVWXYZ ")

(defn random-character []
  (rand-nth alphabet))

;; Generates a seed DNA.
(defn random-string [length]
  (apply str (repeatedly length random-character)))

;; Mutates character according to mutation rate.
(defn mutate-character [rate c]
  (if (<= (rand) rate)
    (random-character)
    c))

;; Mutates DNA based on rate.
(defn mutate-string [dna rate]
  (apply str
    (map (partial mutate-character rate) dna)))

;; Repeatedly generate mutations according to rate and
;; generation size.
(defn reproduce [dna gen-size rate]
  (repeatedly gen-size #(mutate-string dna rate)))

;; Naive method to calculate distance of strings. If a
;; character is in the correct position then place a 1
;; else 0 then sum the list.
(defn fitness-score [target dna]
  (let [correct (fn [x y]
                  (if ( = x y)
                    1
                    0))]
    (reduce +
      (map correct dna target))))

;; Get a zipped map of strings in the population to their
;; fitness score. Rank in descending order and take the key
;; of the most fit.
(defn find-fittest [population target]
  (key
   (first (sort-by last >
      (zipmap population
              (map (partial fitness-score target) population))))))

;; Start with a parent and recursively mutate and select the
;; fittest until done.
(defn run-weasel [target gen-size rate]
  (let [seed (random-string (count target))]
    (loop [parent seed generation 0]
      (println generation ": " parent)
      (let [population (reproduce parent gen-size rate)
            fittest (find-fittest population target)]
        (if (= fittest target)
          (println generation ": " fittest)
          (recur fittest (inc generation)))))))

(def cli-options
  [["-g" "--generation-count COUNT" "Number of progeny per generation."
    :default 100
    :parse-fn #(Integer/parseInt %)]
   ["-m" "--mutation-rate RATE" "Chance of mutation."
    :default 0.05
    :parse-fn #(Float/parseFloat %)
    :validate [#(< 0 % 1)]]
   ["-t" "--target PHRASE" "Target string."
    :default "METHINKS IT IS LIKE A WEASEL"]
   ["-h" "--help"]])

(defn exit [status msg]
  (println msg)
  (System/exit status))

(defn -main [& args]
  (let [{:keys [options arguments errors summary]}
               (parse-opts args cli-options)
        target (string/upper-case (:target options))
        gen-count (:generation-count options)
        rate (:mutation-rate options)]
    (cond
      (:help options) (exit 1 summary)
      errors (exit 1 (string/join \newline errors)))
    (run-weasel target gen-count rate)))
