(ns rotational-cipher.core)

(def alphabet '(\A \B \C \D \E \F \G \H \I \J \K \L \M \N \O \P \Q \R \S \T \U \V \W \X \Y \Z))
(def indexed-alphabet (zipmap alphabet (range)))

(defn rotate-alphabet [count]
  (into {} (map-indexed (fn [idx val]
                          (let [key (- idx (rem count 26))]
                            [(cond
                               (> key 25) (- key 26)
                               (< key 0) (+ key 26)
                               :else key)
                             val]))
                        alphabet)))

(defn rotate [input cipher]
  (let [cipher-alphabet (rotate-alphabet cipher)
        lower-cipher-alphabet (into {} (map (fn [[k v]] [k (Character/toLowerCase v)]) cipher-alphabet))]
    (apply str (map (fn [char]
                      (let [index (indexed-alphabet (Character/toUpperCase char))]
                        (if (nil? index)
                          char
                          (if (Character/isUpperCase char)
                            (get cipher-alphabet index)
                            (get lower-cipher-alphabet index))))) input))))