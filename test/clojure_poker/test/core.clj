(ns clojure-poker.test.core
  (:use [clojure-poker.core])
  (:use [clojure.test]))

(deftest deck-has-52-cards
  (is
   (= (count deck) 52)))

(deftest deck-has-all-suites-of-aces
  (is (some #{(card-of :ace :clubs)} deck))
  (is (some #{(card-of :ace :diamonds)} deck))
  (is (some #{(card-of :ace :hearts)} deck))
  (is (some #{(card-of :ace :spades)} deck)))

(deftest royal-flush
  (is (= true (royal-flush? [(card-of :ten :clubs)
			     (card-of :jack :clubs)
			     (card-of :queen :clubs)
			     (card-of :king :clubs)
			     (card-of :ace :clubs)])))
  (is (= false (royal-flush? [(card-of :ten :diamonds)
			      (card-of :jack :clubs)
			      (card-of :queen :clubs)
			      (card-of :king :clubs)
			      (card-of :ace :clubs)])))
  (is (= false (royal-flush? [(card-of :ten :clubs)
			      (card-of :jack :clubs)
			      (card-of :queen :clubs)
			      (card-of :king :clubs)
			      (card-of :nine :clubs)]))))

(deftest straight-flush
  (is (= true (straight-flush? [(card-of :two :clubs)
		   	        (card-of :three :clubs)
			        (card-of :four :clubs)
			        (card-of :five :clubs)
			        (card-of :six :clubs)])))
  (is (= false (straight-flush? [(card-of :two :hearts)
		   	         (card-of :three :clubs)
			         (card-of :four :clubs)
			         (card-of :five :clubs)
			         (card-of :six :clubs)]))))

(deftest four-of-a-kind
  (is (= true (four-of-a-kind? [(card-of :two :clubs)
		   	        (card-of :two :hearts)
			        (card-of :two :spades)
			        (card-of :two :diamonds)
			        (card-of :six :clubs)])))
  (is (= false (four-of-a-kind? [(card-of :two :clubs)
		   	         (card-of :two :hearts)
			         (card-of :two :spades)
			         (card-of :six :diamonds)
			         (card-of :six :clubs)]))))
  
(deftest straight
  (is (= true (straight? [(card-of :ten :clubs)
			  (card-of :jack :diamonds)
			  (card-of :queen :hearts)
			  (card-of :king :clubs)
			  (card-of :ace :clubs)])))
  (is (= false (straight? [(card-of :two :clubs)
			   (card-of :jack :diamonds)
			   (card-of :queen :hearts)
			   (card-of :king :clubs)
			   (card-of :ace :clubs)]))))

(deftest flush
  (is (= true (flush? [(card-of :four :clubs)
		       (card-of :jack :clubs)
		       (card-of :queen :clubs)
		       (card-of :king :clubs)
		       (card-of :ace :clubs)])))
  (is (= false (flush? [(card-of :four :clubs)
		        (card-of :jack :clubs)
		        (card-of :queen :clubs)
		        (card-of :king :clubs)
		        (card-of :ace :hearts)]))))

  