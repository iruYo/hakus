(ns rle.core)


(defn run-length-encode2 [s]
  (->> s
       (partition-by identity)
       (mapcat #(if (= 1 (count %))
                  [(first %)]
                  [(count %) (first %)]))
       ;(apply str)
       ))

(defn run-length-encode "encodes a string with run-length-encoding" [plain-text]
  (->> plain-text
       (partition-by identity)
       (map frequencies)
       (reduce (fn [string freq-map]
                 (str string
                      (let [length (apply str (vals freq-map))]
                        (when-not (= length "1")
                          length))
                      (apply str (keys freq-map)))) "")))

(defn run-length-decode "decodes a run-length-encoded string" [cipher-text]
  (apply str (map (fn [[_ count letter]]
                    (apply str (repeat (if (= count "")
                                         1
                                         (Integer/parseInt count))
                                       letter)))
                  (re-seq #"(\d*)([A-Za-z ]{1})" cipher-text))))
