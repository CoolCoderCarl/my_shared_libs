// def call(String text) {
  
//   def t = new Task3()
//   t.printText(text)
  
  
  
// }


def call() {
    node {
        
        stage ('Stage One'){
            String text = 'It is work !'
            task3_class_work(text)
        }
        
        stage ('Stage Two'){
            String text = 'It is work !'
            task3_class_work(text)
        }
        
        stage ('Stage Three'){
            String text = 'It is work !'
            task3_class_work(text)
        }
    }
}
