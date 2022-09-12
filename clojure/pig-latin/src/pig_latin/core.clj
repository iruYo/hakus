(ns pig-latin.core
  (:require [clojure.set :refer [difference]]
            [clojure.string :as s]))

(def alphabet #{\a \b \c \d \e \f \g \h \i \j \k \l \m \n \o \p \q \r \s \t \u \v \w \x \y \z})

(def vowels #{\a \e \i \o \u})
(def vowels-regex (re-pattern (str "^(yt|xr|[" (apply str vowels) "])(.*)")))

(def consonants (difference alphabet vowels))
(def consonants-regex (re-pattern (str "^(sch|ch|qu|thr|th|rh|[" (apply str consonants) "](?:qu)?)(.*)")))

(defn word->piglatin [word]
  (let [[_ vowel _] (re-matches vowels-regex word)
        [_ consonant rest] (re-matches consonants-regex word)]
    (cond
      (some? vowel) (str word "ay")
      (some? consonant) (str rest consonant "ay")
      :else word)))

(defn translate [sentence]
  (s/join " " (map word->piglatin (s/split sentence #" "))))

;yttriaay | yttria

