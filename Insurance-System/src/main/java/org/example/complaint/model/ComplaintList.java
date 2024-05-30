package org.example.complaint.model;

import org.example.complaint.Complaint;

public interface ComplaintList {
    public void add(Complaint complaint);

    public void delete(Complaint complaint);

    public Object read();

    public void update();
}
