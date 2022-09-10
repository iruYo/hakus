(ns pig-latin.core
  (:require [clojure.set :refer [difference union]]
            [clojure.string :as s]))

(def alphabet #{"a" "b" "c" "d" "e" "f" "g" "h" "i" "j" "k" "l" "m" "n" "o" "p" "q" "r" "s" "t" "u" "v" "w" "x" "y" "z"})
(def vowels #{"a" "e" "i" "o" "u"})
(def consonants (difference alphabet vowels))

(defn split-consonant-from-word [word]
  (map #(apply str %) (split-with #(contains? consonants %) word)))

(defn starts-with-seq? [word seq]
  (some #(s/starts-with? word %) seq))

(defn vowel-sound? [word]
  (let [vowel-sounds (union vowels #{"xr" "xy"})]
    (starts-with-seq? word vowel-sounds)))

(defn consonant-sound? [word]
  (starts-with-seq? word consonants))

(defn consonant-sound-with-qu? [word]
  (when (consonant-sound? word)
    (when-let [split-word (second (split-consonant-from-word word))]
      (= "qu" (take 2 split-word)))))

(defn consonant-sound-with-y? [word]
  word)


(defn translate [word]
  (cond
    (vowel-sound? word) (str word "ay")
    (consonant-sound-with-qu? word) word
    (consonant-sound-with-y? word) (str word "ay")
    (consonant-sound? word) (let [word-seq (split-consonant-from-word word)]
                              (str (second word-seq) (first word-seq) "ay"))
    :else word))
