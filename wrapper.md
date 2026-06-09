# latinc clipboard hotkey (GNOME / X11)

Press a hotkey → clipboard contents transliterated in place by `latinc`.

## Workflow

1. Select text, `Ctrl+C` to copy.
2. Hit hotkey (e.g. `Ctrl+Super+L`).
3. `Ctrl+V` to paste transliterated result.

## Requirements

- X11 session (`echo $XDG_SESSION_TYPE` → `x11`).
- `latinc` on PATH (`/usr/bin/latinc`).
- `xsel`:
  ```
  sudo apt install xsel
  ```

## Script

`~/.local/bin/latinc-selection`:

```sh
#!/bin/sh
export DISPLAY="${DISPLAY:-:1}"
sel=$(xsel -b -o 2>/dev/null)
[ -z "$sel" ] && exit 0
latinc "$sel" | xsel -b -i
```

```
chmod +x ~/.local/bin/latinc-selection
```

## Hotkey

Settings → Keyboard → View and Customize Shortcuts → Custom Shortcuts → +
- Name: `latinc transliterate`
- Command: `/home/eugene/.local/bin/latinc-selection`
- Shortcut: `Ctrl+Super+L`

## Notes

- `xsel -b` operates on the CLIPBOARD selection (Ctrl+C/Ctrl+V), not the PRIMARY (mouse) selection.
- `xsel` exits cleanly per call — no daemon zombies (unlike `xclip -i` default).
- Empty clipboard → no-op.
