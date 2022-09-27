(ns rotational-cipher.core-test
  (:require [clojure.test :refer :all]
            [rotational-cipher.core :refer :all]))

(deftest rotate-a-by-1
  (is (= (rotate "a" 1) "b")))

(deftest rotate-a-by-26-same-output
  (is (= (rotate "a" 26) "a")))

(deftest rotate-a-by-0-same-output
  (is (= (rotate "a" 0) "a")))

(deftest rotate-m-by-13
  (is (= (rotate "m" 13) "z")))

(deftest rotate-n-by-13-with-wrap
  (is (= (rotate "n" 13) "a")))

(deftest rotate-capital-letters
  (is (= (rotate "OMG" 5) "TRL")))

(deftest rotate-spaces
  (is (= (rotate "O M G" 5) "T R L")))

(deftest rotate-numbers
  (is (= (rotate "Testing 1 2 3 testing" 4) "Xiwxmrk 1 2 3 xiwxmrk")))

(deftest rotate-punctuation
  (is (= (rotate "Let's eat, Grandma!" 21) "Gzo'n zvo, Bmviyhv!")))

(deftest rotate-opposite-direction
  (is (= (rotate "b" -1) "a")))

(deftest rotate-opposite-past-first-letter
  (is (= (rotate "B" -2) "Z")))


(deftest rotate-opposite-past-letter-count
  (is (= (rotate "B" -28) "Z")))

(deftest rotate-forward-then-backwards-same-number-of-steps
  (is (=  (rotate
           (rotate "B" 28) -28) "B")))

(deftest rotate-all-letters
  (is (= (rotate "The quick brown fox jumps over the lazy dog." 13) "Gur dhvpx oebja sbk whzcf bire gur ynml qbt.")))
