(ns rotational-cipher.core)

(def alphabet "abcdefghijklmnopqrstuvwxyz")


(defn rotate [string rot]
  (let [rotated (take 26 (drop (mod rot 26) "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"))
        cipher (zipmap (str alphabet (clojure.string/upper-case alphabet))
                       (concat rotated (map clojure.string/upper-case rotated)))]
    (apply str (map #(cipher % %) string))))

(defn rotate3 [text key]
  (let [shifted (take 26 (drop (mod key 26) (cycle alphabet)))
        cipher (zipmap (str alphabet (clojure.string/upper-case alphabet))
                       (concat shifted (map clojure.string/upper-case shifted)))]
    (->> #break text
         (map #(if (Character/isLetter %) (cipher %) %))
         (apply str))))