package org.example.complaint.model;

import java.util.ArrayList;
import java.util.List;

public class ComplaintListImpl implements ComplaintList {

    private final List<Complaint> complaintList = new ArrayList<>();

    @Override
    public void add(Complaint complaint) {
        complaintList.add(complaint);
    }

    @Override
    public void delete(Complaint complaint) {
        complaintList.remove(complaint);
    }

    @Override
    public Object read() {
        return complaintList;
    }

    @Override
    public void update() {

    }
}
