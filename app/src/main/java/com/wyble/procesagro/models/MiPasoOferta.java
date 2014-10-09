package com.wyble.procesagro.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by david on 10/3/14.
 */
public class MiPasoOferta {

    private int id;

    private int paso_oferta_id;

    private Boolean is_checked;

    public MiPasoOferta(int paso_oferta_id, Boolean is_checked) {
        this.paso_oferta_id = paso_oferta_id;
        this.is_checked = is_checked;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaso_oferta_id() {
        return paso_oferta_id;
    }

    public void setPaso_oferta_id(int paso_oferta_id) {
        this.paso_oferta_id = paso_oferta_id;
    }

    public Boolean getIs_checked() {
        return is_checked;
    }

    public void setIs_checked(Boolean is_checked) {
        this.is_checked = is_checked;
    }

    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        try {
            obj.put("paso_oferta_id", this.getPaso_oferta_id());
            obj.put("is_checked", this.getIs_checked());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public JSONArray toJSONArray() {
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray.put(this.toJSON());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonArray;
    }
}
