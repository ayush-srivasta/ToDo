# Product Requirements Document (PRD)

**Product Name:** SharedLists  
**Version:** 1  
**Date:** November 2025  
**Owner:** Priyanshu Gaurav

---

## 1. 🎯 Product Overview

### 1.1 Vision

> **“Make everyday collaboration effortless and dependable — even without internet.”**

SharedLists is an **offline-first shared to-do app** designed for small groups.  
Users can create shared lists for groceries, chores, or trips. Each list has a category that adapts the app’s **UI, tone, and notifications** to its purpose.  
All actions — adding, editing, completing tasks — work fully offline and sync automatically when the device reconnects.

---

### 1.2 Objectives

1. Deliver a **fast, reliable, and offline-first** shared list experience.
    
2. Allow users to **create context-aware lists** that feel tailored (Grocery, Chores, Trip, General).
    
3. Increase user engagement via **home screen widgets** and **real-time sync** once online.
    
4. Build a **modular foundation** for future expansion into multiple categories and advanced features.
    


---

## 2. 👥 Target Audience

### 2.1 Primary

- Families or roommates managing **grocery** or **chore** lists (where network can drop, like in markets or basements).
    
- Friends planning **trips** where connectivity varies.
    
- Couples managing **shared errands** or event prep.
    

### 2.2 Secondary

- Individuals using personal lists who value **speed and reliability** without waiting for network responses.
    

---

## 3. 🧩 Core Product Principles

|Principle|Description|
|---|---|
|**Offline-First, Always Available**|All key functions (create, edit, complete, reorder tasks) work without internet. Data syncs quietly once online.|
|**Simplicity First**|The app should “just work” — add and check tasks in one or two taps.|
|**Context-Aware Design**|Lists feel tailored to purpose via category-driven UI and language.|
|**Shared by Default**|Collaboration is central; lists are easily shared and synced.|
|**Glanceable & Actionable**|Widgets and notifications drive micro-interactions.|
|**Trust Through Transparency**|Offline states, sync status, and ownership clearly shown.|

---

## 4. 🧱 Product Structure

|Layer|Description|
|---|---|
|**User**|Signs in (email/OTP or Google). Local cache of all lists.|
|**List**|The main container. Stores title, category, members, last synced time.|
|**Category**|Defines presentation and metadata schema (Grocery, Chores, Trip, General).|
|**Task**|Fully local object with unique UUID, pending sync state, and metadata.|
|**Activity Feed**|Synced incrementally when online; shows who did what and when.|

---

## 5. ⚙️ Core Features & Requirements

### 5.1 Offline-First Behavior

- All lists and tasks are stored locally (persistent DB).
    
- Each action updates the **local model instantly** and marks as `pending_sync`.
    
- When the device reconnects:
    
    - Changes are **merged** (last-write-wins or conflict dialog if both sides edited).
        
    - Sync indicators (✓ synced / ↻ syncing / ⚠ error).
        
- No blank states offline — all cached lists remain accessible.
    
- Network loss is silent, non-blocking, and recoverable.
    

---

### 5.2 List Creation & Sharing

- Create new list → choose category → optionally invite others.
    
- Share via link or code (works offline → queued until reconnect).
    
- Members can:
    
    - Join via link/code (on first sync).
        
    - Leave or mute notifications.
        

---

### 5.3 Task Management

- Add, edit, delete, complete tasks — all offline.
    
- Reorder tasks locally.
    
- Assign to member (if known from local cache).
    
- Category-specific metadata:
    
    - **Grocery:** Quantity, Unit
        
    - **Chores:** Recurrence
        
    - **Trip:** Date, Notes
        
    - **General:** Title + Notes
        

---

### 5.4 Notifications

- Local notifications (offline reminders) + Push (online events).
    
- Category-based tone:
    
    - Grocery: “Ankit added 2kg Apples.”
        
    - Chores: “You’re assigned to ‘Wash dishes’.”
        
- Smart merge: push notifications suppressed if user already saw local update.
    

---

### 5.5 Widgets

**Goal:** Enable instant access and offline actions.

|Widget Type|Description|Offline Behavior|
|---|---|---|
|**List Widget**|Displays top tasks from selected list.|Tasks editable offline; updates sync later.|
|**Smart Widget**|Adapts layout to list category.|Fully local until sync.|
|**Multi-List Overview (later)**|Shows all active lists.|Cached locally; no online dependency.|

---

### 5.6 Activity Feed

- Shows historical actions (cached offline).
    
- Syncs new events once online.
    
- Lightweight diffing mechanism for efficient updates.
    

---

### 5.7 UI & Experience

- Offline indicator (e.g., subtle banner “Offline – saving locally”).
    
- Status feedback for sync (“All caught up ✓” or “Syncing 3 changes…”).
    
- Minimal, clean layout with category accent color.
    
- Per-category header & icon:
    
    - Grocery 🛒 Green
        
    - Chores 🧹 Blue
        
    - Trip ✈️ Orange
        
    - General 📋 Neutral
        

---

## 6. 🧠 Non-Functional Requirements

|Area|Requirement|
|---|---|
|**Offline Availability**|100% core actions (create/edit/delete/complete) must work offline.|
|**Sync Efficiency**|Sync delta < 100KB per list typical.|
|**Latency**|Offline action latency < 100ms; online sync < 2s.|
|**Conflict Handling**|Automatic merge; user resolution only when essential.|
|**Battery Impact**|Background sync optimized; no constant polling.|
|**Resilience**|Sync retry with exponential backoff.|
|**Security**|Local data encrypted; sync over HTTPS only.|


---

## 7. 📊 Metrics to Track

|Metric|Purpose|
|---|---|
|Offline Session Rate|Core reliability measure.|
|Offline Action Success|% of actions completed offline without error.|
|Sync Completion Time|Average delay between offline action and remote sync.|
|Retention (7/30-day)|Product stickiness.|
|Widget Usage|Engagement metric.|
|Active Lists|Breadth of app use.|

---

## 8. 🔮 Future Considerations

- Revise & expand the categories offered.
- Use AI to determine the UI based on Category by determining metadata.
- Edge AI suggestions (e.g., “Add recurring item?”). 
- Voice Assistant to add/update a task in any List
    

---

## 9. 📌 Summary Snapshot

|Attribute| Detail                                                          |
|---|-----------------------------------------------------------------|
|**Product Name**| SharedLists                                          |
|**Tagline**| “Always there — shared lists that work even offline.”           |
|**Core Value**| Offline-first shared lists that adapt to purpose.               |
|**MVP Focus**| Grocery domain, local-first sync, category modularity.          |
|**Differentiator**| Works fully offline + context-aware UX.                         |
|**Engagement Driver**| Offline widgets and smart notifications.                        |
|**Vision**| Be the most dependable micro-collaboration app for small groups. |
