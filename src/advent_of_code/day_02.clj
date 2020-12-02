(ns advent-of-code.day-02
  (:require [advent-of-code.parse :as parse]))

#_[(1 3) \a "abcde"]
(defn valid-pw-1?
  [input]
  (let [[rng ch pw] input]
    (->> (filter #{ch} pw)
         ((fn [chs] (<= (first rng) (count chs) (last rng)))))))

(defn valid-pw-2?
  [input]
  (let [[rng ch pw] input
        p1          (nth pw (dec (first rng)))
        p2          (nth pw (dec (last rng)))]
    (->> [p1 p2]
         (filter #{ch})
         count
         (= 1))))

(defn part-1
  "Day 02 Part 1"
  [input]
  (->> input
       parse/password-data
       (map parse/password-line)
       (map valid-pw-1?)
       (filter true?)
       count))

(defn part-2
  "Day 02 Part 2"
  [input]
  (->> input
       parse/password-data
       (map parse/password-line)
       (map valid-pw-2?)
       (filter true?)
       count))
