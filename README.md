# Lab 2 — ADT Implementations + Performance Shootout

COSC 310 Advanced Java. Implements Stack, Queue, and PriorityQueue ADTs over both
ArrayList and DLinkedList backings, plus a binary heap PQ, then benchmarks them.

## Layout

```
chapter9/    ADT interfaces + 6 implementations + provided BinaryHeapPriorityQueue
my/util/     DLinkedList + DNode (course helpers)
benchmark/   BenchmarkDriver — sanity checks + timing harness
WRITEUP.md   Analysis writeup (also rendered as WRITEUP.pdf)
WRITEUP.pdf  Submission-ready PDF version of the writeup
benchmark_output.txt   Raw output from one benchmark run (cited in writeup)
Lab 2 Instructions.pdf Original assignment spec
```

## Implementations

- `chapter9.ArrayListStack` — backed by `java.util.ArrayList`
- `chapter9.DLinkedListStack` — backed by `my.util.DLinkedList` (tail = top)
- `chapter9.ArrayListQueue` — circular buffer in an `ArrayList`
- `chapter9.DLinkedListQueue` — enqueue tail, dequeue head via `removeFirst()`
- `chapter9.SortedArrayListPriorityQueue` — sorted ASC by priority, linear-scan insert
- `chapter9.SortedDLinkedListPriorityQueue` — sorted ASC by priority, linear-traversal insert
- `chapter9.BinaryHeapPriorityQueue` — provided reference (read-only)

Priority convention: lower integer = higher priority.

## Build & run

From the project root:

```
javac -d out chapter9/*.java my/util/*.java benchmark/*.java
java -cp out benchmark.BenchmarkDriver
```

The driver prints sanity-check status, then for each implementation reports median
ns/op across 7 trials (with 2 warmups) for each workload, plus a checksum that
must match across all trials.
