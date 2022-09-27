(ns rle.core)

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

(defn run-length-decode "decodes a run-length-encoded string" [cipher-text])
