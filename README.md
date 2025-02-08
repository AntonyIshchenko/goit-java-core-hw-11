## TASK 1

The method takes a list of names as input. It should return a string of the form `1. Ivan, 3. Peter...` with only those names at odd indices (1, 3, etc).

## TASK 2

The method takes a list of strings as input (you can take the list from **Task 1**). It returns a list of these strings in uppercase, and sorted in descending order (from Z to A).

## TASK 3

There is an array:
```
["1, 2, 0", "4, 5"]
```
It is necessary to get all the numbers from the array, and output them in sorted form separated by commas (`","`), for example:
```
"0, 1, 2, 4, 5"
```

## TASK 4

Using `Stream.iterate`, create an infinite stream of random numbers, but do not use `Math.random()`.

Implement your **linear congruent generator**. To do this, start with `x[0] = seed`, and then calculate each subsequent element using a formula like `x[n + 1] = 1 (a x[n] + c) % m` for valid values `a`, `c`, and `m`.

You need to implement a method that takes the parameters `a`, `c`, and `m` as input and returns a `Stream<Long>`.

Use the following data for the test:
```
a = 25214903917
c = 11
m = 2^48 (2 to the power of 48`)
```

## TASK 5

Write a `public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)` method that "shuffles" elements from streams `first` and `second`, stopping when one of the streams runs out of elements.
