package uk.ac.cam.ga354.tick7;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


//TODO:  specify the appropriate import statements

public abstract class PatternPanel extends JPanel {
	
private List<Pattern> patternList;
private JList guiList;
private Pattern currentPattern;

public Pattern getCurrentPattern(){
	return currentPattern;
}

public PatternPanel() {
super();
currentPattern = null;
setLayout(new BorderLayout());
guiList = new JList();
add(new JScrollPane(guiList));
guiList.addListSelectionListener(new ListSelectionListener() {
    public void valueChanged(ListSelectionEvent e) {
     if (!e.getValueIsAdjusting() && (patternList != null)) {
      int sel = guiList.getSelectedIndex();
      if (sel != -1) {
       currentPattern = patternList.get(sel);
       onPatternChange();
      }
     }
    }
   });
}

protected abstract void onPatternChange();

public void setPatterns(List<Pattern> list) {
if (list == null) {
	     currentPattern = null; //if list is null, then no valid pattern
	     guiList.setListData(new String[]{}); //no list item to select
	     return;
	   }
patternList = list;
ArrayList<String> names = new ArrayList<String>();
for (Pattern p : list){
	names.add(p.getName() + " (" + p.getAuthor() +")" );
	currentPattern = list.get(0); //select first element in list
    guiList.setSelectedIndex(0);  //select first element in guiList
} 
guiList.setListData(names.toArray());
} 
}