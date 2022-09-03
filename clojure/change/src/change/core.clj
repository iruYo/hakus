(ns change.core)

(defn div-with-remainder [dividend divisor]
  ((juxt quot mod) dividend divisor)) 

(defn div-set [set remainder]
  (map (fn [coin] {coin (div-with-remainder remainder coin)}) set))

(defn smallest-div [divided-set]
  (apply min-key #(apply second (vals %)) divided-set))

(defn issue [coin coin-set]
  (if (or (< coin 0) (neg? coin))
    (throw (IllegalArgumentException. "cannot change"))
    (loop [remaining coin
           change '()
           remaining-set (filter (partial >= remaining) (sort > coin-set))]
      (if (= remaining 0)
        (flatten change)
        (let [current-coin (first remaining-set)
              [result remainder] (div-with-remainder remaining current-coin)]
          (if (empty? remaining-set)
            (throw (IllegalArgumentException. "cannot change"))
            (recur remainder (conj change (repeat result current-coin)) (rest remaining-set))))))))



;'(5 10 21 25) 63

