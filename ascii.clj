; Solution to a basic CodinGame problem
(comment "
Input
Line 1: the width L of a letter represented in ASCII art. All letters are the same width.

Line 2: the height H of a letter represented in ASCII art. All letters are the same height.

Line 3: The line of text T, composed of N ASCII characters.

Following lines: the string of characters ABCDEFGHIJKLMNOPQRSTUVWXYZ? Represented in ASCII art.

Output
The text T in ASCII art.
The characters a to z are shown in ASCII art by their equivalent in upper case.
The characters that are not in the intervals [a-z] or [A-Z] will be shown as a question mark in ASCII art.
Constraints
0 < L < 30
0 < H < 30
0 < N < 200
")
 (ns Solution
  (:gen-class))

; Auto-generated code below aims at helping you parse
; the standard input according to the problem statement.
(defn abs [x] (max x (- x)))
(defn -main [& args]
  (let [L (read) H (read) _ (read-line) T (read-line)]
    (loop [i H]
      (when (> i 0)
        (let [ROW (read-line)]
            ;(println ROW)
            (println 
                (clojure.string/join 
                    (map 
                        (fn [tuple] 
                            (subs 
                                  ROW 
                                  (min 
                                       (abs (get tuple :start))
                                       (* L 26))
                                  (min 
                                       (abs (get tuple :end))
                                       (* L 27))))
                        (map
                            (fn [start] {:start start, :end (+ L start)})
                            (map 
                                (fn [x] (* L x))
                                (map 
                                    (fn [x] (- x 97))
                                    (map 
                                         int 
                                         (map 
                                              first 
                                              (clojure.string/split 
                                                    (.toLowerCase T) 
                                                    #"")))))))))
            ; (let [ITER (- (first (map println (map first (clojure.string/split (.toLowerCase T) #"")))) 97)]
            ; )
        (recur (dec i)))))))
