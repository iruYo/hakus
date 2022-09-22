(ns roman-numerals.core-test
  (:require [clojure.test :refer :all]
            [roman-numerals.core :refer :all]))

(deftest one
  (is (= "I" (numerals 1))))

(deftest two
  (is (= "II" (numerals 2))))

(deftest three
  (is (= "III" (numerals 3))))

(deftest four
  (is (= "IV" (numerals 4))))

(deftest five
  (is (= "V" (numerals 5))))

(deftest six
  (is (= "VI" (numerals 6))))

(deftest nine
  (is (= "IX" (numerals 9))))

(deftest twenty-seven
  (is (= "XXVII" (numerals 27))))

(deftest forty-eight
  (is (= "XLVIII" (numerals 48))))

(deftest fifty-nine
  (is (= "LIX" (numerals 59))))

(deftest ninety-three
  (is (= "XCIII" (numerals 93))))

(deftest one-hundred-
  (is (= "CXLI" (numerals 141))))

(deftest one-hundred-sixty-three
  (is (= "CLXIII" (numerals 163))))

(deftest four-hundred-two
  (is (= "CDII" (numerals 402))))

(deftest five-hundred-seventy-five
  (is (= "DLXXV" (numerals 575))))

(deftest nine-hundred-eleven
  (is (= "CMXI" (numerals 911))))

(deftest one-thousand-twenty-four
  (is (= "MXXIV" (numerals 1024))))

(deftest three-thousand
  (is (= "MMM" (numerals 3000))))
