(ns stevedoretest.core

  (:use
   [pallet.common.string :only [quoted]]
   pallet.stevedore
   pallet.stevedore.batch
   clojure.test)
  (:require
   [pallet.stevedore.common :as common])

  )


(require '[pallet.stevedore :refer [script with-script-language]])
(require 'pallet.stevedore.bash) ;; for bash output
(use
 '[pallet.script :only [defscript defimpl with-script-context]]
 '[pallet.stevedore :only [script with-script-language]])


(defscript ls [& args])
(defimpl ls :default [& args]
  ("ls" ~@args))
(defimpl ls [:windows] [& args]
  ("dir" ~@args))

(defn script-run []
  (with-script-language :pallet.stevedore.batch/batch

    (let [tmp "/tmp"
          ]
      (with-script-context [:windows]
        (script


        ;;(doseq [x ["a" "b" "c"]] (println @x))
        (defn foo [x y] ("bar" x))
        (ls "./")
        ("ls" ~tmp)
        ("ls" ~(str "/" "tmp"))
        )))))

(defn script-run-windows []
  (with-script-language :pallet.stevedore.batch/batch
    (let [tmp "/tmp"]
      (with-script-context [:windows]
        (script


        ;;(doseq [x ["a" "b" "c"]] (println @x))
        (defn foo [x y] ("bar" x))
        (~ls "./")
        ("ls" ~tmp)
        ("ls" ~(str "/" "tmp"))
        )))))

(defn script-run-linux []
  (with-script-language :pallet.stevedore.bash/bash
    (let [tmp "/tmp"]
      (with-script-context [:default]
        (script
        (doseq [x ["a" "b" "c"]]
          (println @x))
        (defn foo [x y] ("bar" x))
        ("ls" "./")
        (~ls "./")
        ("ls" ~tmp)
        ("ls" ~(str "/" "tmp")))))))

;(.bindRoot #'pallet.stevedore/*script-language* :pallet.stevedore.bash/bash)





(defn -main
  "I don't do a whole lot."
  [x]
  (println "run:\n"
           (script-run-windows)
           (script-run-linux)))



(comment



(defn script-run [] (with-script-language :pallet.stevedore.bash/bash
   (script/with-script-context [:os-x]
     (pallet.action.exec-script/exec-script(script ("ls -al ./"))))))
  (with-script-language :pallet.stevedore.bash/bash
  (pallet.action.exec-script/exec-script
   (script (ls "./"))))



(with-script-language :pallet.stevedore.bash/bash
  (script/with-script-context [:ubuntu]
    (println (script
      ("ls")))))



(with-script-language :pallet.stevedore.batch/batch
  (with-script-context [:windows]
    (script ("ls"))))




(with-script-language :pallet.stevedore.bash/bash
  (with-script-context [:windows]
    (script ("ls"))))

  (with-script-language :pallet.stevedore.bash/bash
  (with-script-context [:ubuntu]
    (script
      ("ls"))))

(with-script-language :pallet.stevedore.batch/batch
  (with-script-context [:windows]
    (script (~ls a b c))))



  )
