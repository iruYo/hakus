(ns hamming-distance.core)

(defn distance [strand1 strand2]
  (if (= (count strand1) (count strand2))
    (count (filter (partial = false) (map = strand1 strand2)))
    nil))