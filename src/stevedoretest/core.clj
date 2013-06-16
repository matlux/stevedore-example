(ns stevedoretest.core
(:require
   [clojure.string :as string]
   [clojure.test :refer [is testing]]
   [clojure.tools.logging :as logging]
   [pallet.common.filesystem :as filesystem]
   [pallet.common.logging.logutils :as logutils]
   [pallet.common.shell :as shell]
   [pallet.common.string :refer [quoted]]
   [pallet.script :as script]
   [pallet.stevedore :refer :all]
   [pallet.stevedore.bash :refer :all]
   [pallet.stevedore.common]
   [pallet.action.exec-script]
   )


  )

;(.bindRoot #'pallet.stevedore/*script-language* :pallet.stevedore.bash/bash)

(script/defscript ls [& args])
(script/defimpl ls :default [& args]
  (ls ~@args))




(defn script-run [] (with-script-language :pallet.stevedore.bash/bash
   (script/with-script-context [:os-x]
     (pallet.action.exec-script/exec-script (script ("ls -al ./"))))))



(comment
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

(defn -main
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!" (script-run)))
