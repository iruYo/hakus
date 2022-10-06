(ns word-count.core)

(defn word-count [s]
  (->> (re-seq #"\w+" s)
       (map clojure.string/lower-case)
       frequencies))