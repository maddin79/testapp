package testapp

actions {
    action(id: 'cancelAction',
       name: 'Cancel',
       closure: controller.hide,
       mnemonic: 'C',
       shortDescription: 'Cancel'
    )
    action(id: 'okAction',
       name: 'Ok',
       closure: controller.saveUser,
       mnemonic: 'K',
       shortDescription: 'Ok'
    )
}

panel(id: 'content') {
    
    
    label 'Name:'
    textField columns: 20, text: bind('name', target: model)
    label 'Password:'
    passwordField columns: 20, text: bind('password', target: model)
    
    panel() {
        gridLayout(cols: 2, rows: 1)
        button(cancelAction)
        button(okAction)
    }
    
    keyStrokeAction(component: current,
        keyStroke: "ESCAPE",
        condition: "in focused window",
        action: cancelAction)
}
