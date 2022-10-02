(ns series.core)

(defn slices [string length]
  (if-not (= length 0)
    (->> string
         (partition length 1)
         (map #(apply str %)))
    [""]))
