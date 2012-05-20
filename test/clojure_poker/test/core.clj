(ns clojure-poker.test.core
  (:use [clojure-poker.core])
  (:use [clojure.test]))

(deftest deck-has-52-cards
  (is
   (= (count deck) 52)))

(deftest deck-has-all-suites-of-aces
  (is
   (some #{(card-of :ace :diamonds)} deck)))
