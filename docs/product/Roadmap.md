# Roadmap
# Practical, low-risk path

1. **Pick one domain as the launch domain (the one you optimize for).**  
   Example candidates: Grocery/Shopping, Chores/Household, Trip Planning. Pick the one you can best reach and iterate on quickly (easy distribution channels, clear pain, and low switching cost).

2. **Make the product modular from day 0 (design & product).**

    - When creating a list, ask “What is this list for?” → primary choices: Grocery, Chores, Trip, General.

    - But during MVP, only _fully implement_ the deep features for the chosen launch domain. For other categories show generic behavior and a small set of tailored UI strings (so users can still pick them).

    - Architect the UI copy and components as _themeable blocks_ so swapping in domain-specific labels, fields, and notifications is straightforward later.

3. **Ship one _exceptionally good_ domain experience + basic per-list labels.**

    - Example: Grocery launch — full support for quantity/unit/price/reorder and a “reorder last week” template. Chores/Trip options exist as choices but with basic fields only (title, assignee, due date).

4. **Use a feature-flagged rollout for categories.**

    - This allows staggered releases: roll out the Grocery deep features to 10% users, measure, iterate, then expand.

5. **Measure and validate tightly.**

    - Track list creation by category, engagement (tasks added/completed), retention by category, invite rate, and invite-to-join conversion.

    - Use those metrics to decide the next domain to invest in.

6. **Keep onboarding copy domain-sensitive.**

    - Even before deep features exist, changing microcopy, icons, and notification wording per-list dramatically improves perceived fit with little dev cost.


---

# Concrete examples of what to make modular from day 1

- **Microcopy strings** (CTA, empty states, notifications) per category.  
  — Empty state for Grocery: “Your grocery list is empty — add essentials like milk, rice.”  
  — Empty state for Chores: “No chores yet — add something for tonight’s cleanup.”

- **List template system** (templates stored as data, not code): easy to add new templates for new domains.

- **Task schema extensibility**: core fields (title, note, assignee, done) + optional metadata map (quantity, unit, price, booking link). Only surface extras when the category requires them.

- **UI component themes**: icon + label + small layout variations (e.g., item quantity inline for groceries).

- **Notification templates**: category-aware push message templates.


---

# Roadmap (quarterly view — product-only)

- **MVP (0–3 months):** Launch with one domain (e.g., Grocery). Per-list category selector exists but non-launch categories are shallow. Focus on retention loops and invites.

- **Iterate (3–6 months):** Improve core features for the launched domain (templates, reorder, price tracking). Add small domain microcopy improvements for other categories.

- **Second domain (6–9 months):** Pick second category based on metrics and user requests; implement deep features for it.

- **Generalize (9–12 months):** Once you have 2–3 domains mature, formalize the “multi-domain” marketing and position as a genuinely adaptive shared lists app.


---

# UX / Messaging examples (to show how small changes help)

- Notification (Grocery): “Ankit added 2 kg of apples to _Groceries_.”

- Notification (Chores): “Ankit assigned you ‘Clean kitchen’ in _House chores_.”

- Empty state (Trip): “No items yet. Add flights, hotels, or ‘Pack charger’.”


These are cheap to implement and improve perceived relevance dramatically.

---

# Final verdict (short)

**Do the hybrid intelligently:** _Start domain-first for speed and traction_, but implement your per-list category system and modular copy/components at the same time so the app can scale to many domains later. That gives you the marketing and retention benefits of a domain specialist while preserving the flexibility of your idea.
