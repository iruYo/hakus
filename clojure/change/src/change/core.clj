(ns change.core)

(defn div-with-remainder [dividend divisor]
  ((juxt quot mod) dividend divisor)) 

(defn issue [coin coin-set]
  (if (or (< coin 0) (neg? coin))
    (throw (IllegalArgumentException. "cannot change"))
    (loop [remaining coin
           change '()
           remaining-set (filter (partial >= remaining) (sort > coin-set))]
      (let [current-coin (first remaining-set)
            [result remainder] (div-with-remainder remaining current-coin)]
        (if (= remaining 0)
          (flatten change)
          (if (empty? remaining-set)
            (throw (IllegalArgumentException. "cannot change"))
            (recur remainder (conj change (repeat result current-coin)) (rest remaining-set))))))))
