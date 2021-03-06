/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package music.demo.pkg3;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/**
 *
 * @author Kevin
 */
public class DurationList {

    private final int BPM;
    //whole notes     7 
    private final double Double_Whole_note;
    private final double Whole_note;
    private final double Half_note;
    private final double Quarternote;
    private final double Eighth_note;
    private final double Sixteenth_note;
    private final double ThirtySecond_note;
    //dotted notes 7
    private final double Dotted_Double_Whole_note;
    private final double Dotted_Whole_note;
    private final double Dotted_Half_note;
    private final double Dotted_quarter_note;
    private final double Dotted_Eighth_note;
    private final double Dotted_sixteenth_note;
    private final double Dotted_ThirtySecond_note;
// TRIPPLETS 6

    private final double Triplet_quarter_note;
    private final double Triplet_eighth_note;
    private final double Triplet_sixteenth_note;
    private final double Triplet_ThirtySecond_note;
    private final double[] Note_To_Durations;

    private HashMap<String, Double> Duration_To_Value;
    private static LinkedHashMap<String, String> Duration_To_Abbreviation;
    //  private int [] TotalDurations;

    public DurationList(String musicString) {
        this.BPM = getTempo(musicString);
        this.Double_Whole_note = 480.0 / BPM;
        this.Whole_note = 240.0 / BPM;
        this.Half_note = 120.0 / BPM;
        this.Quarternote = 60.0 / BPM;
        this.Eighth_note = 30.0 / BPM;
        this.Sixteenth_note = 15.0 / BPM;
        this.ThirtySecond_note = 7.5 / BPM;

        this.Dotted_Double_Whole_note = 720.0 / BPM;
        this.Dotted_Whole_note = 360.0 / BPM;
        this.Dotted_Half_note = 180.0 / BPM;
        this.Dotted_quarter_note = 90.0 / BPM;
        this.Dotted_Eighth_note = 45.0 / BPM;
        this.Dotted_sixteenth_note = 22.5 / BPM;
        this.Dotted_ThirtySecond_note = 11.25 / BPM;

        this.Triplet_quarter_note = 40.0 / BPM;
        this.Triplet_eighth_note = 20.0 / BPM;
        this.Triplet_sixteenth_note = 10.0 / BPM;
        this.Triplet_ThirtySecond_note = 5.0 / BPM;

        this.Note_To_Durations = new double[]{Double_Whole_note, Whole_note, Half_note, Quarternote, Eighth_note,
            Sixteenth_note, ThirtySecond_note,
            Dotted_Double_Whole_note, Dotted_Whole_note, Dotted_Half_note, Dotted_quarter_note, Dotted_Eighth_note,
            Dotted_sixteenth_note, Dotted_ThirtySecond_note,
            Triplet_ThirtySecond_note, Triplet_sixteenth_note, Triplet_quarter_note, Triplet_eighth_note};
        populateDurationToValue();
        populateDurationToAbbreviation();
    }

    public void populateDurationToValue() {
        Duration_To_Value = new HashMap<>();
        Duration_To_Value.put("Double_Whole_note", Double_Whole_note);
        Duration_To_Value.put("Whole_note", Whole_note);
        Duration_To_Value.put("Half_note", Half_note);
        Duration_To_Value.put("Quarternote", Quarternote);
        Duration_To_Value.put("Eighth_note", Eighth_note);
        Duration_To_Value.put("Sixteenth_note", Sixteenth_note);
        Duration_To_Value.put("ThirtySecond_note", ThirtySecond_note);

        Duration_To_Value.put("Dotted_Double_Whole_note", Dotted_Double_Whole_note);
        Duration_To_Value.put("Dotted_Whole_note", Dotted_Whole_note);
        Duration_To_Value.put("Dotted_Half_note", Dotted_Half_note);
        Duration_To_Value.put("Dotted_quarter_note", Dotted_quarter_note);
        Duration_To_Value.put("Dotted_Eighth_note", Dotted_Eighth_note);
        Duration_To_Value.put("Dotted_sixteenth_note", Dotted_sixteenth_note);
        Duration_To_Value.put("Dotted_ThirtySecond_note", Dotted_ThirtySecond_note);

        Duration_To_Value.put("Triplet_quarter_note", Triplet_quarter_note);
        Duration_To_Value.put("Triplet_eighth_note", Triplet_eighth_note);
        Duration_To_Value.put("Triplet_sixteenth_note", Triplet_sixteenth_note);
        Duration_To_Value.put("Triplet_ThirtySecond_note", Triplet_ThirtySecond_note);

    }

    public void populateDurationToAbbreviation() {

        Duration_To_Abbreviation = new LinkedHashMap<>();
        Duration_To_Abbreviation.put("Triplet_ThirtySecond_note", "t*");
        Duration_To_Abbreviation.put("ThirtySecond_note", "t");
        Duration_To_Abbreviation.put("Dotted_ThirtySecond_note", "t.");
        Duration_To_Abbreviation.put("Triplet_sixteenth_note", "s*");
        Duration_To_Abbreviation.put("Sixteenth_note", "s");
        Duration_To_Abbreviation.put("Dotted_sixteenth_note", "s.");
        Duration_To_Abbreviation.put("Triplet_eighth_note", "i*");
        Duration_To_Abbreviation.put("Eighth_note", "i");
        Duration_To_Abbreviation.put("Dotted_Eighth_note", "i.");
        Duration_To_Abbreviation.put("Triplet_quarter_note", "q*");
        Duration_To_Abbreviation.put("Quarternote", "q");
        Duration_To_Abbreviation.put("Dotted_quarter_note", "q.");
        Duration_To_Abbreviation.put("Half_note", "h");
        Duration_To_Abbreviation.put("Dotted_Half_note", "h.");
        Duration_To_Abbreviation.put("Whole_note", "w");
        Duration_To_Abbreviation.put("Dotted_Whole_note", "w.");
        Duration_To_Abbreviation.put("Double_Whole_note", "ww");
        Duration_To_Abbreviation.put("Dotted_Double_Whole_note", "ww.");

    }

    private int getTempo(String musicString) {
        int start = musicString.indexOf('T');
        int end = musicString.indexOf(' ', start);
        return Integer.parseInt(musicString.substring(start + 1, end));
    }

    public double[] getNoteToDurations() {
        return Note_To_Durations;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Field f : getClass().getDeclaredFields()) {
            sb.append(f.getName());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public LinkedHashMap<String, String> getDuration_To_Abbreviation() {
        return Duration_To_Abbreviation;
    }

    public HashMap<String, Double> getDuration_To_Value() {
        return Duration_To_Value;
    }

    public double getDoubleWholeNote() {
        return Double_Whole_note;
    }

}
