(ns advent-of-code.day-01
  (:require [clojure.math.combinatorics :as combo]
            [advent-of-code.parse :as parse]))

(defn helper
  [input n]
  (->> (combo/combinations (parse/line-integers input) n)
       (map (juxt identity #(apply + %)))
       (filter #(= 2020 (last %)))
       ffirst
       (apply *)))

(defn part-1
  "Day 01 Part 1"
  [input]
  (helper input 2))

(defn part-2
  "Day 01 Part 2"
  [input]
  (helper input 3))
