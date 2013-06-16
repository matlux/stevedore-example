(ns stevedoretest.core



  )


(require '[pallet.stevedore :refer [script with-script-language]])
(require 'pallet.stevedore.bash) ;; for bash output

(defn script-run [] (with-script-language :pallet.stevedore.bash/bash
   (script
    ("ls"))))

;(.bindRoot #'pallet.stevedore/*script-language* :pallet.stevedore.bash/bash)





(defn -main
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!" (script-run)))



(comment

(script/defscript ls [& args])
(script/defimpl ls :default [& args]
  (ls ~@args))


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
