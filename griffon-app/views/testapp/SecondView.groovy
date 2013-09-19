package testapp

optionPane(  
    id: 'pane',  
    messageType: JOptionPane.INFORMATION_MESSAGE,  
    optionType: JOptionPane.DEFAULT_OPTION,  
    title: bind {model.title},
    message: bind {model.message}
)  
