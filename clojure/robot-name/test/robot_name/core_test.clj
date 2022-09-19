(ns robot-name.core-test
  (:require [clojure.test :refer :all]
            [robot-name.core :refer :all]))

(deftest robot-name-test
  (let [a-robot (robot)
        its-name (robot-name a-robot)]
    (is (re-seq #"[A-Z]{2}\d{3}" its-name))))


(deftest name-matches-pattern
  (let [a-robot (robot)
        its-name (robot-name a-robot)]
    (is (= its-name (robot-name a-robot)))))


(deftest different-robots-different-names
  (let [a-robot (robot)
        its-name (robot-name a-robot)]
    (is (not= its-name (-> (robot) robot-name)))))


(deftest new-name-matches
  (let [a-robot (robot)
        its-original-name (robot-name a-robot)
        its-new-name (do (reset-name a-robot)
                         (robot-name a-robot))]
    (is (re-seq #"[A-Z]{2}\d{3}" its-new-name))))


(deftest new-name-different
  (let [a-robot (robot)
        its-original-name (robot-name a-robot)
        its-new-name (do (reset-name a-robot)
                         (robot-name a-robot))]
    (is (not= its-original-name its-new-name))))

(deftest new-name-does-not-change-until-reset
  (let [a-robot (robot)
        its-original-name (robot-name a-robot)
        its-new-name (do (reset-name a-robot)
                         (robot-name a-robot))]
    (is (= its-new-name (robot-name a-robot)))))


(deftest new-names-different-each-time
  (let [a-robot (robot)
        its-original-name (robot-name a-robot)
        its-new-name (do (reset-name a-robot)
                         (robot-name a-robot))]
    (is (not= its-new-name (do (reset-name a-robot)
                             (robot-name a-robot))))))
