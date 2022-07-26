(ns change.core)

; lifted from https://exercism.org/tracks/clojure/exercises/change/solutions/leetwinski

; reduce function takes empty map, builder function and range from 1 to desired coin
; "builder function" builds smallest possible changeset for each value in range up until desired coin
; - takes a map and current range value
; - filter any coin greater then current range 
; - maps each coin over current map. 
; - - get value for: current range minus coin, return empty vector if empty.
; - - append current coin to that vector

; - - EXPLAINATION  #{1 5 10 25 100}
; - - vector contains possible set to make up current amount.
; - - vectors are keyed by their range value
; - - 10 is calculated first by coin value 1,
; - - 10 minus 1 equals 9, retrieving vector of 9 containing [1 1 1 1 5] 
; - - appending coin value 1 gives the possible vector [1 1 1 1 5 1]
; - - repeating with coin 5 next, 10 minus 5 equals 5, retrieving 5 vector [5], appending 5 equals [5 5]
; - - again with coin 10, 10 - 10 = 0, no vector returns empty vector, appending 10 equals [10]
; - - possible change sets for 10 = [1 1 1 1 1 5] from 9 (10 - 1), [5 5] from 5 (10 - 5), [10] from null (10 - 10)
; - - by substracting a coin value from the current range value, the resulting change set inherently can make up the current range by adding the coin value

; - of all possible coin sets, choose set with least amount of entries
; - add this coin set to reduce map, keyed by current range value


; recreated from explanation above.
(defn calc-change [sum coin-set]
  (let [change-sets (reduce (fn [change-sets coin]
                              (->> coin-set
                                   (filter (partial >= coin))
                                   (map #(conj (change-sets (- coin %) []) %))
                                   (apply min-key count)
                                   (assoc change-sets coin)))
                            {} (drop-while (partial > (apply min coin-set)) (range 1 (inc sum))))]
    (change-sets sum)))

(defn issue [sum coin-set]
  (when (or (neg? sum)                                      ; error when neg sum, ...
            (and (every? (partial < sum) coin-set)          ; ... when every coin in set is greater then sum
                 (not (= 0 sum)))                           ; 0 is fine though
            (not (= 0 (reduce #(rem %1 %2) sum coin-set)))) ; ... not divisible at all
    (throw (IllegalArgumentException. "cannot change")))
  (sort < (calc-change sum coin-set)))