(ns roman-numerals.core)

(def conversion {1 \I
                 5 \V
                 10 \X
                 50 \L
                 100 \C
                 500 \D
                 1000 \M})

(defn numerals [arabic]
  (letfn [(greatest-conversion [nr]
            (->> conversion
                 (filter (fn [[k _]] (>= nr k)))
                 (apply max-key first)))]
    (loop [result ""
           remainder arabic]
      (let [[value symbol] (greatest-conversion remainder)
            roman (str result symbol)
            leftover (- remainder value)]
        (if (= leftover 0)
          roman
          (recur roman (- remainder value)))))))