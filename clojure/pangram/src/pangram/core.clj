(ns pangram.core)

(def alphabet #{\a \b \c \d \e \f \g \h \i \j \k \l \m
                \n \o \p \q \r \s \t \u \v \w \x \y \z})

(defn pangram? [string]
(-> string
    clojure.string/lower-case
    set
    (every? alphabet)))

(defn bad-pangram? [string]
  (let [check (for [c alphabet]
                (some #(= c %) (clojure.string/lower-case string)))]
    (every? some? check)))

(defn worse-pangram? [string]
  (let [check (for [c alphabet]
                (some #(= c %) (clojure.string/lower-case string)))]
    (if (every? some? check)
      true
      false)))