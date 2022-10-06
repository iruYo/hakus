(ns strain.core)

(defn retain [f input]
  (reduce (fn [result elm]
            (if (f elm)
              (conj result elm)
              result))
          [] input))

(defn discard [f input]
  (retain (complement f) input))