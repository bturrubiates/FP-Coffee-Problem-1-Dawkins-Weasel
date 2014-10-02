# FP Coffee Problem 1: Dawkins' Weasel

## Introduction

[Dawkins' weasel](http://en.wikipedia.org/wiki/Weasel_program)
is a thought experiment introduced by Richard Dawkins in his book
*The Blind Watchmaker*. It is meant to demonstrate evolutionary systems
by a process of combining random variation with selection.

The weasel problem is framed around the well-known
[infinite monkey theorem](http://en.wikipedia.org/wiki/Infinite_monkey_theorem).

Given a 28 character sequence the probability that the monkey will produce
the sequence is quite low due to the sheer number of possible combinations of
characters. The modified problem uses this premise to show that the random
variation combined with cumulative selection leads to a much higher probability
in producing the given target.

## Problem Statement

In this variation we simulate selection of the fittest using strings. The
string both represents the DNA and the individuals. The starting point is a
randomized 28 character string. The eventual goal is to achieve the target
string:

> METHINKS IT IS LIKE A WEASEL

This is accomplished by starting with the input and treating it as the
initial generation. At each generational step, the individual is duplicated
repeatedly. Each duplication has a chance of random error that mutates
the individual into being further or closer from the intended target.
The progeny of the individual are then inspected and the most fit is
selected to continue in the next generational step.

## Ouput

The generation number and the 'fittest' string are printed after each
generational step. Eventually the sequence converges on the target.

Example:
```
Generation 01:   WDLTMNLT DTJBKWIRZREZLMQCO P
Generation 02:   WDLTMNLT DTJBSWIRZREZLMQCO P
Generation 10:   MDLDMNLS ITJISWHRZREZ MECS P
Generation 20:   MELDINLS IT ISWPRKE Z WECSEL
Generation 30:   METHINGS IT ISWLIKE B WECSEL
Generation 40:   METHINKS IT IS LIKE I WEASEL
Generation 43:   METHINKS IT IS LIKE A WEASEL
```

## Notes
There is no restriction on the language choice but functional concepts should
be applied.

Feel free to modify the problem for increased complexity. The problem may implement
the concepts of reproduction, cumulative selection, and randomization. The
implementation for those concepts are quite open to interpretation, but be ready
to discuss your modifications.

## Soundtrack
Soundtrack for the problem is the recently released album
[*This Is All Yours*](https://play.spotify.com/album/6TbkWAqqY4nhQnYim61IU8)
by Alt-J.

## Implementation
This repository is initially distributed to reveal problem of the week. It also
hosts my personal solution. This solution is pretty barebones but it solves the
weasel problem as described.

It can be executed using the following commands:
```
lein run
lein run -- -g 1000 -m 0.05 -t "METHINKS IT IS LIKE A BADGER"
```
The -g option specifies the count of progeny per generation.
The -m option specifies the mutation rate.
The -t specifies the target phrase.

The default values are 100, 0.05, and "METHINKS IT IS LIKE A WEASEL"

Note the -- between lein run and the parameters.
