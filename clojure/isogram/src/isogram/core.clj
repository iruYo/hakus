(ns isogram.core)

(defn isogram? [words]
  (->> words
       clojure.string/lower-case
       (filter #(not (or (= \- %) (= \  %))))
       (apply distinct?)))


;frequencies
;vals
;(every? (partial = 1))