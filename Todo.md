## Todo







## done
ladder Row test case:
true false -> draw at second -> false so ladder draws nothing.
true false true -> draw at second -> false so ladder draws nothing.
false false false -> draw at second -> true so ladder draws something.
false false false true -> draw at third -> false

ladder Result test case:
false false -> index 0 arrives 0, index 1 arrives 1, index 2 arrives 2
false true -> index 0 arrives 0, index 1 arrives 2, index 2 arrives 1

false true
true false -> index 0 arrives 1, index 1 arrives 2, index 2 arrives 0

false true false
true false false
true false true -> index 0 arrives 0, index 1 arrives 3, index 2 arrives 1,
                    index 3 arrives 2