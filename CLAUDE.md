# AlgoCamp System Design: Notes Repo

This repo holds my personal study notes (`HLD/`, `LLD/`) as markdown files.
Nothing here is application code. The notes are mine, so their content stays mine.

## Commands

Both jobs run **only when I ask**. Never start either one on your own.

### 1. `go` / `fix`: beautify one notes file

Trigger: I say "go", "fix", or "go and fix".
Target: the file I name. If I don't name one, use the file open in the IDE. If neither is clear, ask.
Do not run this on `HLD/README.md`. That file belongs to job 2.

Touch only that one file, never its neighbours. Do it right away, with no confirmation. Fix:

- **Structure:** proper heading hierarchy (`#`, `##`, `###`). Loose titles become headings.
- **Formatting:** lists, tables, spacing, alignment, and code fences with a language tag.
- **Language:** grammar, spelling, punctuation, and clearer wording.
- **Readability:** split a long sentence into shorter ones, or into sub-bullets, only when it clearly reads better. Do not split sentences that are already fine. Use your own judgment. The goal is notes that look and read as well as possible, with the same meaning and the same points.
- **Links:** fix broken relative links and image paths (e.g. `HLD/images/...`) so they point to the right file.

Hard rules:

- **Stay faithful to what I wrote.** Never delete, change, or reinterpret a fact, example, number, or code line. Reword only for clarity.
- **Do not change my content.** Never alter or remove what I wrote. Only extra information from you may be added, and only inside a `> 💡 **Added explanation:**` block (see General).
- **If the notes look incomplete** (a missing step, an unfinished sentence, a skipped concept, a missing trade-off or fix), do not ask me. Fill the gap directly with a short 💡 block next to the relevant point. Keep it as short as possible: one or two lines, only the key fact. I will tell you to remove a block if I don't want it.
- Do not ask questions unless you are truly blocked (e.g. no file is named or open).
- Keep my file names and folder layout. Only edit the one file.
- When done, give a short summary of what changed. Do not commit.

### 2. `update the summary readme`: refresh the HLD summary

Trigger: I say "update the summary readme". Nothing else triggers it. Never update it as a side effect of job 1 or any other task.
Target: `HLD/README.md`, the revision guide built from every note in `HLD/`.

Steps:

1. Compare `HLD/` (numbered folders and the files in them) with `HLD/README.md`. Use `git status` and `git diff` to spot new or changed notes.
2. Add or update only what changed. Do not rewrite sections that are already correct.
3. Keep the guide's existing conventions:
   - One numbered top-level section per `HLD/(N) Folder` and a numbered subsection per topic, with the Table of Contents updated.
   - A **Quick recap** at the top of each section.
   - `> 💡 **Added explanation:**` blocks for extras that are not in my notes.
   - `> ⚠️ **Check this:**` blocks for unclear, unfinished, or wrong-looking notes. Keep my original wording and also list them in **Notes to Double Check**.
   - New terms go in the **Glossary**. Update **The Big Picture** tree for new sections.
4. Every point from my notes must appear in the guide, in simpler words. Never drop a point to save space.
5. When done, summarize which sections were added or changed. Do not commit.

## General

- **Anything I did not write goes in a 💡 block.** Every piece of information, explanation, example, or fact that comes from you and not from my notes must sit inside a `> 💡 **Added explanation:**` blockquote, in every file and for both commands. Nothing outside a 💡 block may be new information, so I can always tell my words from yours.
- Notes are Markdown. Keep my tone and level of detail.
- Never run `git commit` or `git push`. I commit myself.
- Never create files I did not ask for.
- The summary is HLD-only. There is no LLD summary unless I ask for one.
