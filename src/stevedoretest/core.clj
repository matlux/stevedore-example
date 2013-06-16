(ns stevedoretest.core



  )


(require '[pallet.stevedore :refer [script with-script-language]])
(require 'pallet.stevedore.bash) ;; for bash output
(use
 '[pallet.script :only [defscript defimpl with-script-context]]
 '[pallet.stevedore :only [script with-script-language]])


(defscript ls [& args])
(defimpl ls :default [& args]
  (ls ~@args))


(defn script-run []
  (with-script-language :pallet.stevedore.bash/bash
    (let [tmp "/tmp"]
      (script
       (doseq [x ["a" "b" "c"]]
         (println @x))
       (defn foo [x y] ("bar" x))
       ("ls" "./")
       ("ls" ~tmp)
       ("ls" ~(str "/" "tmp"))))))

;(.bindRoot #'pallet.stevedore/*script-language* :pallet.stevedore.bash/bash)





(defn -main
  "I don't do a whole lot."
  [x]
  (println "run:" (script-run)))



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
