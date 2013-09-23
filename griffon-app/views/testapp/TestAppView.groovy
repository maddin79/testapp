package testapp

actions {
    action(id: 'okAction',
       name: 'Ok',
       closure: controller.login,
       mnemonic: 'K',
       shortDescription: 'Ok'
    )
}

application(title: 'TestApp',
  preferredSize: [320, 240],
  pack: true,
  //location: [50,50],
  locationByPlatform: true,
  iconImage:   imageIcon('/griffon-icon-48x48.png').image,
  iconImages: [imageIcon('/griffon-icon-48x48.png').image,
               imageIcon('/griffon-icon-32x32.png').image,
               imageIcon('/griffon-icon-16x16.png').image]) {
    
    panel() {
        button(okAction)
    }
}
