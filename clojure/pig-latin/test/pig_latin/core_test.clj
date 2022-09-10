(ns pig-latin.core-test
  (:require [clojure.test :refer :all]
            [pig-latin.core :refer :all]))

;; ay is added to words that start with vowels

(deftest word-beginning-with-a
  (is (= "appleay"
         (translate "apple"))))

(deftest word-beginning-with-e
  (is (= "earay"
         (translate "ear"))))

(deftest word-beginning-with-i
  (is (= "iglooay"
         (translate "igloo"))))

(deftest word-beginning-with-o
  (is (= "objectay"
         (translate "object"))))

(deftest word-beginning-with-u
  (is (= "underay"
         (translate "under"))))

(deftest word-beginning-with-a-vowel-and-followed-by-a-qu
  (is (= "equalay"
         (translate "equal"))))

;; first letter and ay are moved to the end of words that start with consonants

(deftest word-beginning-with-p
  (is (= "igpay"
         (translate "pig"))))

(deftest word-beginning-with-k
  (is (= "oalakay"
         (translate "koala"))))


(deftest word-beginning-with-y
  (is (= "ellowyay"
         (translate "yellow"))))

(deftest word-beginning-with-x
  (is (= "enonxay"
         (translate "xenon"))))

(deftest word-beginning-with-q-without-a-following-u
  (is (= "atqay"
         (translate "qat"))))

;; some letter clusters are treated like a single consonant

(deftest word-beginning-with-ch
  (is (= "airchay"
         (translate "chair"))))

(deftest word-beginning-with-qu
  (is (= "eenquay"
         (translate "queen"))))


(deftest word-beginning-with-qu-and-a-preceding-consonant
  (is (= "aresquay"
         (translate "square"))))

(deftest word-beginning-with-th
  (is (= "erapythay"
         (translate "therapy"))))

(deftest word-beginning-with-thr
  (is (= "ushthray"
         (translate "thrush"))))

(deftest word-beginning-with-sch
  (is (= "oolschay"
         (translate "school"))))

;;  some letter clusters are treated like a single vowel
(deftest word-beginning-with-yt
  (is (= "yttriaay"

         (translate "yttria"))))

(deftest word-beginning-with-xr
  (is (= "xrayay"
         (translate "xray"))))

(deftest word-beginning-with-consonants-followed-by-y
  (is (= "ythmrhay"
         (translate "rhythm"))))

(deftest two-letter-word-ends-with-y
  (is (= "ymay"
         (translate "my"))))

;; phrases are translated
(deftest a-whole-phrase
  (is (= "ickquay astfay unray"
         (translate "quick fast run"))))