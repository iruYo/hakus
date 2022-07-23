(ns pig-latin.core
  (:require [clojure.set :refer [difference union]]))

(def alphabet #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z})
(def vowels #{\a \e \i \o \u})
(def consonants (difference alphabet vowels))

(defn vowel-sound? [word]
  (let [first (first word)
        second (apply str (take 2 word))
        vowel-sounds (union vowels #{"xr" "xy"})]
    (or (contains? vowel-sounds first) (contains? vowel-sounds second))))

(defn consonant-sound? [word]
  (let [beginning (apply str (take-while #(contains? consonants %) word))]
    (not (= beginning ""))))

(defn split-consonant-from-word [word]
  (map #(apply str %) (split-with #(contains? consonants %) word)))

(defn consonant-sound-with-qu? [word]
  (if (consonant-sound? word)
    (map #(apply str %) (split-with #(contains? (union consonants #{"qu"}) %) word))))

(defn consonant-sound-with-y? [word]
)
; (if (some zero? (map (partial mod number) primes))
 (defn translate [word] ;; <- arglist goes here 
   (cond
     (vowel-sound? word) (str word "ay")
     (consonant-sound-with-qu? word) (nil)
     (consonant-sound-with-y? word) (str word "ay")
     (consonant-sound? word) (let [word-seq (split-consonant-from-word word)]
                               (str (second word-seq) (first word-seq) "ay"))
     :else word))
