(ns com.bendyworks.om-counter
  (:require [om.core :as om]
            [om.dom :as dom]))

(defonce app-state (atom {:counter 0}))

(defn counter-view [app owner]
  (reify
    om/IRender
    (render [_]
      (apply dom/div nil
         [(dom/button #js {:className "inc-button"} "up")
         (dom/div #js {:className "counter"} (:counter app) )
         (dom/button #js {:className "dec-button"} "down")]))))

(om/root counter-view app-state
         {:target (.getElementById js/document "app")})
