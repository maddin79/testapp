package testapp

actions {
    action(id: 'cancelAction',
       name: app.getMessage('FirstUserView.button.cancel.label') ?:'Cancel',
       closure: controller.hide,
       mnemonic: app.getMessage('FirstUserView.button.cancel.mnemonic') ?:'C',
       accelerator: shortcut(app.getMessage('FirstUserView.button.cancel.accelerator') ?: 'C'),
       shortDescription: app.getMessage('FirstUserView.button.cancel.tooltip') ?:'Cancel creation'
    )
    action(id: 'okAction',
       name: 'Ok',
       closure: controller.saveUser,
       mnemonic: 'K',
       shortDescription: 'Ok'
    )
}

panel(id: 'content') {
    migLayout(layoutConstraints: 'fill')
    
    label 'Name:'
    textField columns: 20, text: bind('name', target: model), constraints: 'growx, wrap'
    label 'Password:'
    passwordField columns: 20, text: bind('password', target: model), constraints: 'growx, wrap'
    
    button cancelAction 
    button okAction
    
    
    keyStrokeAction(component: current,
        keyStroke: "ESCAPE",
        condition: "in focused window",
        action: cancelAction)
}
