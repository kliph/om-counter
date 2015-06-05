(ns com.bendyworks.om-counter
  (:require [om.core :as om]
            [om.dom :as dom]))

(defonce app-state (atom {:counter 0}))

(defn counter-view [app owner]
  (reify
    om/IRender
    (render [_]
      (apply dom/div nil
             [(dom/button #js {:className "increment-button"
                               :onClick (fn [e]
                                          (om/transact! app :counter inc))}
                          "⇮")
              (dom/div #js {:className "counter"} (:counter app))
              (dom/button #js {:className "decrement-button"
                               :onClick (fn [e]
                                          (om/transact! app :counter dec))}
                          "⇮")]))))

(om/root counter-view app-state
         {:target (.getElementById js/document "app")})
