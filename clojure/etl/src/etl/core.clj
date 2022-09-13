(ns etl.core
  (:require [clojure.string :as s]))

(defn transform [scores]
  (->> scores
       (map (fn [score]
              (zipmap (map s/lower-case (val score))
                      (repeat (key score)))))
       (into {})))

(defn transform2 [scores]
  (into {} (for [[score words] scores
                 word words]
             [(s/lower-case word) score])))