# UI UX Requirements

> Notification and Widget designs are not covered in this document. 



## 🩵 1. Splash + Google Sign-In Flow

### 🎯 Goal

Authenticate user and transition smoothly into main experience.
### 🧩 Key UI Elements

- App logo animation

- Tagline: _“Always available. Always in sync.”_

- “Continue with Google” button (single CTA)


### 🪄 Interactions

- Tap → Google OAuth → success → navigates to Dashboard

- If offline → disable button with tooltip “Connect to internet to sign in.”


### 🌐 Offline Behavior

- Login **not available** offline.

- Offline mode not accessible before sign-in.


---

## 🧭 2. Main Navigation Layout (Global)

### 🎯 Goal

Provide consistent navigation and quick access to all core features.

### 🧩 Tabs in Bottom Navigation

1. **🏠 Home / Dashboard**

2. **🗂️ Lists**

3. **👤 Profile / Account**


### 🧩 Global Layout

- Top AppBar (dynamic title)

- Bottom navigation bar (always visible post-login)

- Floating Action Button (FAB)

    - Contextual:

        - On “Home” → Add quick task (future)

        - On “Lists” → Create New List


---

## 🏠 3. Home / Dashboard Tab

### 🎯 Goal

Give an overview of what’s recent, active, or shared with you.

### 🧩 Key UI Elements

- Section: “Recently Updated Lists” (sorted by most recent activity)

    - Up to 5 recent lists shown

- Each card includes:

    - List title

    - Category icon + subtle colored accent (tint or left border)

    - Member avatars (if shared)

    - “Last updated X min ago” label

    - Small sync state chip (✓ / ↻ / ⚠)


### 🪄 Interactions

- Tap → Open List Detail

- Long press → Rename, Share, Delete (context menu)

- Pull down → Trigger sync manually

- FAB → Create new list


### 🌐 Offline Behavior

- Can create/edit lists/tasks offline

- Sync pending shown as “↻ Pending sync”

- No new members or invites offline


---

## 🗂️ 4. Lists Tab

### 🎯 Goal

Primary space to browse and manage all lists — sorted by recency and color-coded by category.

### 🧩 Key UI Elements

- Header: “My Lists”

- Optional search bar (future)

- **List cards (recency-sorted):**

    - **Background tint or left color strip** (based on category)

    - Category icon (🛒 / 📋)

    - Title (bold)

    - Subtitle: “Updated 3h ago”

    - Member avatars (if any)

    - Sync icon (✓ / ↻)

- Floating “+” FAB → Create new list


### 🎨 Category-Based Color Logic

|Category|Primary Color|Accent (Tint / Border)|Icon|
|---|---|---|---|
|Grocery|#8EB69B|#DAF1DE|🛒|
|General|#235347|#E5F1ED|📋|

Each list item uses:

- Light tint background (`8–12%` opacity of accent color)

- Left color strip or 2dp shadow using primary color

- White card surface when selected


### 🪄 Interactions

- Tap → Open List Detail

- Swipe left → Delete

- Long press → Rename, Share, Delete

- Pull to refresh → Trigger manual sync


### 🧭 Sorting

- Lists sorted by `last_updated_at DESC`

- Latest activity (task added, edited, or marked done) updates timestamp


### 🌐 Offline Behavior

- Lists and tasks fully editable offline

- Sync icons visible (↻ unsynced changes)

- Invite/share actions disabled offline


### 🪄 Transitions

- Add → Card slides in from top

- Delete → Fade + collapse animation

- Sync success → “All caught up ✓” toast


---

## ➕ 5. Create New List (Bottom Sheet)

### 🎯 Goal

Create new list quickly with category and title.

### 🧩 Key UI Elements

- Text field: “List name”

- Category selector (pill buttons):

    - 🛒 Grocery

    - 📋 General

- “Create” button (primary)


### 🪄 Interactions

- Tap category → highlight and show sample color/icon

- Tap “Create” → immediately adds to local DB → navigates to List Detail


### 🌐 Offline Behavior

- Works offline (queued sync)

- New list appears with ↻ sync indicator


---

## 🧺 6. List Detail Screen (Updated)

### 🎯 Goal

Core working area — view, create, and manage all tasks within a specific list.  
Each task clearly shows **ownership and responsibility** (`Created by`, `Assignee`, and `Last assigned by`) while maintaining smooth offline interaction and clean visual structure.

---

### 🧩 Common Layout

#### **Top AppBar**

- **Back button** → Returns to previous screen.

- **Title** → List name (editable on tap).

- **Category icon** → 🛒 / 📋 (reflects category).

- **Share icon** → Opens Invite Sheet (disabled offline).

- **Sync state chip** → Displays status (`✓ Synced`, `↻ Syncing`, `⚠ Failed`).


#### **Task List Sections**

1. **Pending Tasks** – always visible.

2. **Completed Tasks** – collapsible (default collapsed).

    - Header shows count: “Completed (4)”.

    - Expand to reveal done tasks in faded style.


#### **Add Bar (bottom of screen)**

- Grocery lists → _“Add item...”_

- General lists → _“Add task...”_

- Inline entry, one-tap to add.

- Auto-focus on new line after adding.


---

### 🎨 Category Styling

|Category|Header Color|FAB Color|Task Accent|
|---|---|---|---|
|Grocery|#8EB69B|#8EB69B|#DAF1DE|
|General|#235347|#235347|#E5F1ED|

**Rules:**

- Subtle background tint for task cards (`8–12%` of accent).

- Left border strip or small icon matches category color.

- FAB and active icons use the category’s primary color.


---

### 🧠 Task Card Layout

Each task shows key ownership and status details.

```
☐  Buy Apples
   Assigned to: Priyanshu
   Created by: Ankit
   Last assigned by: Ravi — 2h ago
   ↻ Pending sync
```

**Elements:**

- Checkbox → toggle completion (instant).

- Title → main label.

- Subtext (stacked lines):

    - Line 1: `Assigned to: [user name or “Unassigned”]`

    - Line 2: `Created by: [creator name]`

    - Line 3: _(only if reassigned)_ `Last assigned by [user] — [relative time]`

- Sync indicator (↻) visible if offline changes exist.

- Right side: small avatar of current assignee (color-coded border).

- Completed tasks → dimmed with strikethrough title.


---

### 🪄 Interactions

|Action|Behavior|
|---|---|
|**Add task**|Inline add; instantly visible in list and stored locally (even offline).|
|**Tap checkbox**|Toggles done/pending immediately; syncs later if offline.|
|**Long press task**|Opens Task Detail Bottom Sheet.|
|**Swipe left**|Delete task (soft delete, undo snackbar).|
|**Tap assignee name/avatar**|Opens Assignee Picker bottom sheet.|
|**Pull down**|Triggers manual sync (shows spinner in AppBar).|
|**Tap list title**|Rename inline, auto-saves (syncs later if offline).|

---

### 👥 Assignment Behavior (Integrated)

**For every task:**

- Has `Created by` (immutable) and `Assignee` (editable).

- Any list member can change the assignee.

- Only existing list members can be assigned.

- “Unassigned” is a valid state (default).

- Reassignments update `Last assigned by` + timestamp.


**Assignee Picker Bottom Sheet:**

- List of all list members + “Unassigned”.

- Current assignee highlighted.

- Tap instantly applies selection locally.

- Offline → marks task as “↻ Pending sync” and queues change.


**Feedback:**

- Toast: “Assigned to Priyanshu.”

- Activity feed entry (if visible): “Ankit assigned ‘Buy Apples’ to Priyanshu.”

- In task card: “Last assigned by Ankit — just now.”


---

### 🌐 Offline Behavior

|Capability|Status|
|---|---|
|Create task|✅ Works offline, sync queued|
|Edit title/details|✅ Works offline|
|Toggle done|✅ Works offline|
|Assign / reassign|✅ Works offline (to cached members only)|
|Delete task|✅ Works offline (queued delete)|
|Invite/share|❌ Disabled while offline|
|Member picker|⚠ Shows cached members only|
|Sync state|Visible as “↻ Pending sync” on affected items|

**Offline visual cues:**

- Banner: “Offline — changes saved locally.”

- Gray dot or ↻ beside unsynced items.

- Sync triggered automatically on reconnection.

- If sync fails → red warning chip: “Couldn’t sync — retrying soon.”


---

### ✨ Feedback States

|State|UI Feedback|
|---|---|
|**Offline**|Gray banner “Offline — changes saved locally.”|
|**Syncing**|Subtle footer: “Syncing your changes…”|
|**Synced**|Banner: “All caught up ✓” fades out after 2s.|
|**Conflict**|Toast: “Assignment updated elsewhere — showing latest version.”|
|**Failed sync**|Red chip: “Couldn’t sync — retrying.”|

---

### 💬 Micro Interactions

- **Add task:** slide-in animation from bottom.

- **Mark done:** checkmark ripple animation in category color.

- **Reassign:** avatar pulse → fade transition of assignee text.

- **Offline banner:** slides down softly; retracts after reconnect.

- **All caught up ✓:** fades in/out, subtle vibration feedback.


---

## 📝 7. Task Detail Bottom Sheet

### 🎯 Goal

Allow users to **view and edit complete details of a single task** — including assignment, ownership, and category-specific attributes — while maintaining offline-first behavior and instant UI responsiveness.

---

### 🧩 Layout Overview

**Structure:**

- Header: Task title (editable inline)

- Content area: grouped sections

- Footer: “Delete” + optional “Save” (only if unsaved changes exist)


---

### 🧩 Common Fields

|Field|Description|Behavior|
|---|---|---|
|**Title**|Editable text input|Inline edit; updates locally instantly|
|**Notes / Description**|Multi-line field|Expandable; supports up to 300 chars|
|**Assigned To**|Member picker dropdown / bottom sheet|Shows current assignee, allows reassignment to any list member or “Unassigned”|
|**Created By**|Read-only label showing creator name|Visible to all members|
|**Last Assigned By**|Read-only; shows name and relative time|Updates automatically when assignee changes|
|**Status**|Toggle or checkbox for Done / Pending|Instant local update|
|**Delete Task**|Red button (bottom)|Soft delete → confirmation dialog + undo snackbar|

---

### 🧩 Grocery-Specific Fields

|Field|Type|Description|
|---|---|---|
|**Quantity**|Numeric input|e.g., “2”|
|**Unit**|Dropdown|Options: kg, g, L, ml, pcs|
|**Price**|Optional numeric input|For budgeting (optional field)|

**UI grouping:** “Shopping Details” section under a divider.  
Subtle green accent in icons and input outlines (based on category color).

---

### 🧩 General-Specific Fields

|Field|Type|Description|
|---|---|---|
|**Priority**|Dropdown|Options: Low / Normal / High|
|**Due Date**|Optional (future)|Placeholder field (disabled in MVP)|

**UI grouping:** “Task Details” section.  
Blue or teal accent used for interactive components.

---

## 👥 8. Share / Invite Sheet

### 🎯 Goal

Allow inviting others to collaborate on a list.

### 🧩 Key UI Elements

- Header: “Invite Members”

- Buttons:

    - Copy Link

    - Share via WhatsApp

    - Show Code

- Member list with avatars + remove button


### 🌐 Offline Behavior

- Entire sheet disabled with message:

  > “You’re offline — sharing unavailable.”


---

## 👤 9. Profile / Account Tab

### 🎯 Goal

Manage account, preferences, and app-level settings.

### 🧩 Sections

- Profile header: Name, Email, Avatar (from Google)

- Options:

    - Manage Devices

    - Clear Local Cache

    - App Settings

    - Feedback

    - Log Out (requires online)

- App version footer


### 🌐 Offline Behavior

- All options viewable, non-destructive actions allowed

- Log Out disabled offline