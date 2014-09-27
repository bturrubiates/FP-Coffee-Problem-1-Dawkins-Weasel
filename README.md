# FP Coffee Problem 1: Dawkins' weasel

## Introduction

[Dawkins' weasel](http://en.wikipedia.org/wiki/Weasel_program)
is a thought experiment introduced in his book *The Blind
Watchmaker*. It is meant to demonstrate evolutionary systems by a process
of combining random variation with selection. 

The weasel problem is framed around the well known 
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

The generation number and the most fit string are printed after each
generation step. Eventually the sequence converges on the target. 

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
A functional programming language should be used. There is no restriction on the
language choice but functional concepts should be applied.

Feel free to modify the problem for increased complexity. The problem must implement
the concepts of sexual reproduction, cumulative selection, and randomization. The
implementation for those concepts are quite open to interpretation, but be ready
to discuss your modifications.

## Soundtrack
Soundtrack for the problem is the recently released album 
[*This Is All Yours*](https://play.spotify.com/album/6TbkWAqqY4nhQnYim61IU8) 
by Alt-J.
